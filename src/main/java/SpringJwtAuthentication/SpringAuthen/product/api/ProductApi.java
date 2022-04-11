package SpringJwtAuthentication.SpringAuthen.product.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductApi {

    @Autowired ProductRepository productRepository;

    @GetMapping
    public List<Product> list(){
        return productRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product){
        Product save = productRepository.save(product);
        URI productURI = URI.create("/products/" + save.getId());

        return ResponseEntity.created(productURI).body(save);
    }

}
