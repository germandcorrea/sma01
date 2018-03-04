package brokers;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.Objects;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.6")
@SarlElementType(9)
@SuppressWarnings("all")
public final class Item {
  private String sku;
  
  private int price;
  
  private int delay;
  
  public Item(final String s, final int p, final int d) {
    this.sku = s;
    this.price = p;
    this.delay = d;
  }
  
  @Pure
  public String getSku() {
    return this.sku;
  }
  
  @Pure
  public int getPrice() {
    return this.price;
  }
  
  @Pure
  public int getDelay() {
    return this.delay;
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
    Item other = (Item) obj;
    if (!Objects.equals(this.sku, other.sku)) {
      return false;
    }
    if (other.price != this.price)
      return false;
    if (other.delay != this.delay)
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
    return result;
  }
}
