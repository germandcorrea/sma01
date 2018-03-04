package brokers;

import brokers.Item;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Event;
import java.util.Objects;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class ProductoCotizado extends Event {
  public String sku;
  
  public int price;
  
  public int delay;
  
  public String proveedor;
  
  public int index;
  
  public ProductoCotizado(final int id, final Item i, final String p) {
    this.sku = i.getSku();
    this.price = i.getPrice();
    this.delay = i.getDelay();
    this.proveedor = p;
    this.index = id;
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
    ProductoCotizado other = (ProductoCotizado) obj;
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
    result = prime * result + Objects.hashCode(this.sku);
    result = prime * result + this.price;
    result = prime * result + this.delay;
    result = prime * result + Objects.hashCode(this.proveedor);
    result = prime * result + this.index;
    return result;
  }
  
  /**
   * Returns a String representation of the ProductoCotizado event's attributes only.
   */
  @SyntheticMember
  @Pure
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("sku  = ").append(this.sku);
    result.append("price  = ").append(this.price);
    result.append("delay  = ").append(this.delay);
    result.append("proveedor  = ").append(this.proveedor);
    result.append("index  = ").append(this.index);
    return result.toString();
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 1371916712L;
}
