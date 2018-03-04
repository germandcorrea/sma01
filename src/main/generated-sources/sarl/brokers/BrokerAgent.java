package brokers;

import brokers.CotizarProducto;
import brokers.Criterios;
import brokers.Item;
import brokers.MejorProducto;
import brokers.ProductRequest;
import brokers.ProductoCotizado;
import brokers.Proveedores;
import com.google.common.base.Objects;
import io.sarl.core.DefaultContextInteractions;
import io.sarl.core.Initialize;
import io.sarl.core.Logging;
import io.sarl.lang.annotation.ImportedCapacityFeature;
import io.sarl.lang.annotation.PerceptGuardEvaluator;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.BuiltinCapacitiesProvider;
import io.sarl.lang.core.DynamicSkillProvider;
import io.sarl.lang.core.Scope;
import io.sarl.lang.core.Skill;
import io.sarl.lang.util.ClearableReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;
import javax.inject.Inject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Inline;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.6")
@SarlElementType(17)
@SuppressWarnings("all")
public class BrokerAgent extends Agent {
  private HashMap prodsRequest;
  
  private int index;
  
  @SyntheticMember
  private void $behaviorUnit$Initialize$0(final Initialize occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info("[BrokerAgent.Initialize]Iniciando Broker");
    HashMap<Object, Object> _hashMap = new HashMap<Object, Object>();
    this.prodsRequest = _hashMap;
    this.index = 0;
  }
  
  @SyntheticMember
  private void $behaviorUnit$ProductRequest$1(final ProductRequest occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info(
      String.format(
        "[BrokerAgent.ProductRequest] Broker atendiendo solicitud de cliente %s producto %s criterio %s", 
        occurrence.cliente, 
        occurrence.sku, 
        occurrence.criterio));
    this.index++;
    DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
    CotizarProducto _cotizarProducto = new CotizarProducto(occurrence.sku, this.index);
    _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_cotizarProducto);
    final HashMap<String, Object> req = new HashMap<String, Object>();
    req.put("SKU", occurrence.sku);
    req.put("CRITERIO", occurrence.criterio);
    req.put("CLIENTE", occurrence.getSource());
    this.prodsRequest.put(Integer.valueOf(this.index), req);
  }
  
  @SyntheticMember
  private void $behaviorUnit$ProductoCotizado$2(final ProductoCotizado occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info(
      String.format(
        "[BrokerAgent.ProductoCotizado] proveedor %s producto %s precio %s demora %s", 
        occurrence.proveedor, 
        occurrence.sku, 
        Integer.valueOf(occurrence.price), 
        Integer.valueOf(occurrence.delay)));
    final HashMap<String, Object> cotizacion = new HashMap<String, Object>();
    cotizacion.put("PROVEEDOR", occurrence.getSource());
    cotizacion.put("PROVEEDOR-NOMBRE", occurrence.proveedor);
    Item _item = new Item(occurrence.sku, occurrence.price, occurrence.delay);
    cotizacion.put("ITEM", _item);
    Object _get = this.prodsRequest.get(Integer.valueOf(occurrence.index));
    final HashMap<String, Object> req = ((HashMap<String, Object>) _get);
    final Criterios criterio = Criterios.valueOf(req.get("CRITERIO").toString());
    Object _get_1 = req.get("CLIENTE");
    final Address cliente = ((Address) _get_1);
    Object _get_2 = req.get("LST-COTIZACION");
    LinkedList<HashMap<String, Object>> lstCotizacion = ((LinkedList<HashMap<String, Object>>) _get_2);
    if ((lstCotizacion == null)) {
      LinkedList<HashMap<String, Object>> _linkedList = new LinkedList<HashMap<String, Object>>();
      lstCotizacion = _linkedList;
      req.put("LST-COTIZACION", lstCotizacion);
    }
    lstCotizacion.add(cotizacion);
    int _size = lstCotizacion.size();
    int _length = Proveedores.values().length;
    boolean _equals = (_size == _length);
    if (_equals) {
      HashMap<String, Object> ganador = null;
      for (final HashMap<String, Object> c : lstCotizacion) {
        {
          final HashMap<String, Object> cot = ((HashMap<String, Object>) c);
          if ((ganador == null)) {
            ganador = cot;
          } else {
            Object _get_3 = cot.get("ITEM");
            final Item itemActual = ((Item) _get_3);
            Object _get_4 = ganador.get("ITEM");
            final Item itemGanador = ((Item) _get_4);
            boolean _equals_1 = criterio.equals(Criterios.PRECIO);
            if (_equals_1) {
              int _price = itemGanador.getPrice();
              int _price_1 = itemActual.getPrice();
              boolean _greaterThan = (_price > _price_1);
              if (_greaterThan) {
                ganador = cot;
              }
            } else {
              boolean _equals_2 = criterio.equals(Criterios.TIEMPO);
              if (_equals_2) {
                int _delay = itemGanador.getDelay();
                int _delay_1 = itemActual.getDelay();
                boolean _greaterThan_1 = (_delay > _delay_1);
                if (_greaterThan_1) {
                  ganador = cot;
                }
              }
            }
          }
        }
      }
      Object _get_3 = ganador.get("ITEM");
      final Item item = ((Item) _get_3);
      Object _get_4 = ganador.get("PROVEEDOR-NOMBRE");
      final String proveedor = ((String) _get_4);
      DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
      String _sku = item.getSku();
      int _price = item.getPrice();
      int _delay = item.getDelay();
      String _string = criterio.toString();
      MejorProducto _mejorProducto = new MejorProducto(_sku, _price, _delay, proveedor, _string);
      final Scope<Address> _function = (Address it) -> {
        UUID _uUID = it.getUUID();
        UUID _uUID_1 = cliente.getUUID();
        return Objects.equal(_uUID, _uUID_1);
      };
      _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_mejorProducto, _function);
    }
  }
  
  @Extension
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  @SyntheticMember
  private transient ClearableReference<Skill> $CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS;
  
  @SyntheticMember
  @Pure
  @Inline(value = "$castSkill(DefaultContextInteractions.class, ($0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || $0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? ($0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = $0$getSkill(DefaultContextInteractions.class)) : $0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS)", imported = DefaultContextInteractions.class)
  private DefaultContextInteractions $CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER() {
    if (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) {
      this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = $getSkill(DefaultContextInteractions.class);
    }
    return $castSkill(DefaultContextInteractions.class, this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
  }
  
  @Extension
  @ImportedCapacityFeature(Logging.class)
  @SyntheticMember
  private transient ClearableReference<Skill> $CAPACITY_USE$IO_SARL_CORE_LOGGING;
  
  @SyntheticMember
  @Pure
  @Inline(value = "$castSkill(Logging.class, ($0$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || $0$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? ($0$CAPACITY_USE$IO_SARL_CORE_LOGGING = $0$getSkill(Logging.class)) : $0$CAPACITY_USE$IO_SARL_CORE_LOGGING)", imported = Logging.class)
  private Logging $CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER() {
    if (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) {
      this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = $getSkill(Logging.class);
    }
    return $castSkill(Logging.class, this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$Initialize(final Initialize occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$Initialize$0(occurrence));
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$ProductRequest(final ProductRequest occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$ProductRequest$1(occurrence));
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$ProductoCotizado(final ProductoCotizado occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$ProductoCotizado$2(occurrence));
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    BrokerAgent other = (BrokerAgent) obj;
    if (other.index != this.index)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + this.index;
    return result;
  }
  
  @SyntheticMember
  public BrokerAgent(final UUID parentID, final UUID agentID) {
    super(parentID, agentID);
  }
  
  @SyntheticMember
  @Inject
  @Deprecated
  public BrokerAgent(final BuiltinCapacitiesProvider provider, final UUID parentID, final UUID agentID) {
    super(provider, parentID, agentID);
  }
  
  @SyntheticMember
  @Inject
  public BrokerAgent(final UUID parentID, final UUID agentID, final DynamicSkillProvider skillProvider) {
    super(parentID, agentID, skillProvider);
  }
}
