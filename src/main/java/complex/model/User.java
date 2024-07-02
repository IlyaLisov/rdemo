package complex.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class User {

    private Long id;
    private BillingStatus status;

    public User(Long id) {
        this.id = id;
        this.status = new BillingStatus();
    }

}
