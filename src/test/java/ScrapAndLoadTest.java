import com.kk.StealMonitor.model.Product;
import com.kk.StealMonitor.service.PageLoader;
import com.kk.StealMonitor.service.scrapers.Scraper;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.UUID;

public class ScrapAndLoadTest {

    @Autowired
    PageLoader pageLoader;

    @MockBean
    Scraper scraper;


    public void loadProductsTest() {
        String url = "https://www.x-kom.pl";
        String divClassName = "sc-bwzfXH sc-1bb6kqq-2 cNKcdN sc-htpNat gSgMmi";
        String scraperPath = "";

        Mockito.when(scraper.scrap(Mockito.any())).thenReturn(new Product(UUID.randomUUID(),
                "link",
                "name",
                "name",
                "old",
                "new",
                "re",
                "limit",
                "img",
                "category"));


        List<Product> products = pageLoader.loadProducts(url, divClassName, scraperPath);

    }

}
