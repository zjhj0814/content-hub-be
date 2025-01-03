package tibetyo.content_hub.scheduler;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tibetyo.content_hub.crawler.DramaCrawler;
import tibetyo.content_hub.service.AvailabilityService;
import tibetyo.content_hub.service.ContentCastService;
import tibetyo.content_hub.util.WebDriverUtil;

import java.time.Duration;

@Profile("prod") //프로덕션 환경에서만 크롤링 진행
@Component
@RequiredArgsConstructor
public class CrawlScheduler {
    private final WebDriverUtil webDriverUtil;
    private final ContentCastService contentCastService;
    private final AvailabilityService availabilityService;

    @Scheduled(fixedRate = 604800000) //7일
    public void scheduleCrawling() throws InterruptedException {
        System.out.println("Crawling started");

        WebDriver webDriver = webDriverUtil.getDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        try {
            DramaCrawler dramaCrawler = new DramaCrawler(webDriver, webDriverWait, jsExecutor, contentCastService, availabilityService);
            dramaCrawler.crawlContent();
        } catch (Exception e) {
            System.out.println("--------------------");
            System.out.println("Error occurred during crawling: " + e.getMessage());
            System.out.println("--------------------");

        } finally {
            webDriverUtil.quitDriver();

            System.out.println("Crawling finished");
        }
    }
}
