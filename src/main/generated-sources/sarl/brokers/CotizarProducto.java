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
public class CotizarProducto extends Event {
  public String sku;
  
  public int index;
  
  public CotizarProducto(final String s, final int i) {
    this.sku = s;
    this.index = i;
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
    CotizarProducto other = (CotizarProducto) obj;
    if (!Objects.equals(this.sku, other.sku)) {
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
    result = prime * result + this.index;
    return result;
  }
  
  /**
   * Returns a String representation of the CotizarProducto event's attributes only.
   */
  @SyntheticMember
  @Pure
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("sku  = ").append(this.sku);
    result.append("index  = ").append(this.index);
    return result.toString();
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 3775566492L;
}
