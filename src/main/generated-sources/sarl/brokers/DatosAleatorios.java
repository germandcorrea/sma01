package brokers;

import brokers.Clientes;
import brokers.Criterios;
import brokers.Item;
import brokers.Productos;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.6")
@SarlElementType(9)
@SuppressWarnings("all")
public final class DatosAleatorios {
  @Pure
  public static Productos getProducto() {
    final int i = ThreadLocalRandom.current().nextInt(0, Productos.values().length);
    return Productos.values()[i];
  }
  
  @Pure
  public static Clientes getCliente() {
    final int i = ThreadLocalRandom.current().nextInt(0, Clientes.values().length);
    return Clientes.values()[i];
  }
  
  @Pure
  public static Criterios getCriterio() {
    final int i = ThreadLocalRandom.current().nextInt(0, Criterios.values().length);
    return Criterios.values()[i];
  }
  
  @Pure
  public static HashMap<String, Item> getCatalogoProveedorA() {
    final HashMap<String, Item> catalogo = new HashMap<String, Item>();
    String _string = Productos.CARTERA.toString();
    Item _item = new Item(_string, 700, 5);
    catalogo.put(Productos.CARTERA.toString(), _item);
    String _string_1 = Productos.ZAPATOS.toString();
    Item _item_1 = new Item(_string_1, 2000, 5);
    catalogo.put(Productos.ZAPATOS.toString(), _item_1);
    String _string_2 = Productos.CINTURON.toString();
    Item _item_2 = new Item(_string_2, 300, 5);
    catalogo.put(Productos.CINTURON.toString(), _item_2);
    String _string_3 = Productos.BOTAS.toString();
    Item _item_3 = new Item(_string_3, 2500, 5);
    catalogo.put(Productos.BOTAS.toString(), _item_3);
    return catalogo;
  }
  
  @Pure
  public static HashMap<String, Item> getCatalogoProveedorB() {
    final HashMap<String, Item> catalogo = new HashMap<String, Item>();
    String _string = Productos.CARTERA.toString();
    Item _item = new Item(_string, 800, 3);
    catalogo.put(Productos.CARTERA.toString(), _item);
    String _string_1 = Productos.ZAPATOS.toString();
    Item _item_1 = new Item(_string_1, 2100, 3);
    catalogo.put(Productos.ZAPATOS.toString(), _item_1);
    String _string_2 = Productos.CINTURON.toString();
    Item _item_2 = new Item(_string_2, 400, 3);
    catalogo.put(Productos.CINTURON.toString(), _item_2);
    String _string_3 = Productos.BOTAS.toString();
    Item _item_3 = new Item(_string_3, 2600, 3);
    catalogo.put(Productos.BOTAS.toString(), _item_3);
    return catalogo;
  }
  
  @Pure
  public static HashMap<String, Item> getCatalogoProveedorC() {
    final HashMap<String, Item> catalogo = new HashMap<String, Item>();
    String _string = Productos.CARTERA.toString();
    Item _item = new Item(_string, 1200, 1);
    catalogo.put(Productos.CARTERA.toString(), _item);
    String _string_1 = Productos.ZAPATOS.toString();
    Item _item_1 = new Item(_string_1, 2500, 1);
    catalogo.put(Productos.ZAPATOS.toString(), _item_1);
    String _string_2 = Productos.CINTURON.toString();
    Item _item_2 = new Item(_string_2, 800, 1);
    catalogo.put(Productos.CINTURON.toString(), _item_2);
    String _string_3 = Productos.BOTAS.toString();
    Item _item_3 = new Item(_string_3, 3000, 1);
    catalogo.put(Productos.BOTAS.toString(), _item_3);
    return catalogo;
  }
  
  @SyntheticMember
  public DatosAleatorios() {
    super();
  }
}
