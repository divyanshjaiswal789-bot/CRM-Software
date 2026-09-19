@Entity
@Data
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String company;
    private String address;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "assigned_rep_id")
    private User assignedRep;
}