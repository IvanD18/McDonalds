import lombok.Data;
import ru.rosbank.javaschool.dto.FullProductDto;
import ru.rosbank.javaschool.exception.*;
import ru.rosbank.javaschool.product.Potato;
import ru.rosbank.javaschool.product.Sandwich;
import ru.rosbank.javaschool.repository.BasketRepositoryImpl;
import ru.rosbank.javaschool.repository.ProductRepositoryImpl;
import ru.rosbank.javaschool.service.AdministratorProductService;
import ru.rosbank.javaschool.service.AdministratorProductServiceImpl;
import ru.rosbank.javaschool.service.UsersProductService;
import ru.rosbank.javaschool.service.UsersProductServiceImpl;

@Data
public class Main {
    public static void main(String[] args) {
        ProductRepositoryImpl repository = new ProductRepositoryImpl();
        BasketRepositoryImpl basket = new BasketRepositoryImpl();

        final AdministratorProductService adminsService = new AdministratorProductServiceImpl(repository);
        final UsersProductService usersService = new UsersProductServiceImpl(repository,basket);


        try {
            adminsService.save(new Sandwich(

                    0,
                    "burger",
                    10,
                    null,
                    "Cheezeburger",
                    true
            ));
            System.out.println("Successfully added");

        } catch (DataSaveException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("finally");
        }


        try {
            adminsService.save(new Potato(

                    0,
                    "potato free",
                    4,
                    null,
                    "small",
                    false
            ));
            System.out.println("Successfully added");

        } catch (DataSaveException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("finally");
        }


        System.out.println(repository.getById(1));
        System.out.println(repository.getById(2));
        System.out.println(repository.getById(3));
        System.out.println(repository.getById(1).get());
        usersService.addToBasket(FullProductDto.from(repository.getById(2).get()));


    }


}
