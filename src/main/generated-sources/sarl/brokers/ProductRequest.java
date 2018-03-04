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
public class ProductRequest extends Event {
  public String sku;
  
  public String criterio;
  
  public String cliente;
  
  public ProductRequest(final String s, final String c, final String cl) {
    this.sku = s;
    this.criterio = c;
    this.cliente = cl;
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
    ProductRequest other = (ProductRequest) obj;
    if (!Objects.equals(this.sku, other.sku)) {
      return false;
    }
    if (!Objects.equals(this.criterio, other.criterio)) {
      return false;
    }
    if (!Objects.equals(this.cliente, other.cliente)) {
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
    result = prime * result + Objects.hashCode(this.criterio);
    result = prime * result + Objects.hashCode(this.cliente);
    return result;
  }
  
  /**
   * Returns a String representation of the ProductRequest event's attributes only.
   */
  @SyntheticMember
  @Pure
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("sku  = ").append(this.sku);
    result.append("criterio  = ").append(this.criterio);
    result.append("cliente  = ").append(this.cliente);
    return result.toString();
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 5675969267L;
}
