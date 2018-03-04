package brokers;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Event;
import java.util.Objects;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class MejorProducto extends Event {
  public String sku;
  
  public int price;
  
  public int delay;
  
  public String proveedor;
  
  public String criterio;
  
  public MejorProducto(final String s, final int p, final int d, final String pr, final String cr) {
    this.sku = s;
    this.price = p;
    this.delay = d;
    this.proveedor = pr;
    this.criterio = cr;
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
    MejorProducto other = (MejorProducto) obj;
    if (!Objects.equals(this.sku, other.sku)) {
      return false;
    }
    if (other.price != this.price)
      return false;
    if (other.delay != this.delay)
      return false;
    if (!Objects.equals(this.proveedor, other.proveedor)) {
      return false;
    }
    if (!Objects.equals(this.criterio, other.criterio)) {
      return false;
    }
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Objects.hashCode(this.sku);
    result = prime * result + this.price;
    result = prime * result + this.delay;
    result = prime * result + Objects.hashCode(this.proveedor);
    result = prime * result + Objects.hashCode(this.criterio);
    return result;
  }
  
  /**
   * Returns a String representation of the MejorProducto event's attributes only.
   */
  @SyntheticMember
  @Pure
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("sku  = ").append(this.sku);
    result.append("price  = ").append(this.price);
    result.append("delay  = ").append(this.delay);
    result.append("proveedor  = ").append(this.proveedor);
    result.append("criterio  = ").append(this.criterio);
    return result.toString();
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 5064372641L;
}
