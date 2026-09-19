@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAll() { return customerRepository.findAll(); }

    @PostMapping
    public Customer create(@RequestBody Customer customer) { 
        return customerRepository.save(customer); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer details) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customer.setName(details.getName());
        customer.setCompany(details.getCompany());
        return ResponseEntity.ok(customerRepository.save(customer));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable Long id) { customerRepository.deleteById(id); }
}