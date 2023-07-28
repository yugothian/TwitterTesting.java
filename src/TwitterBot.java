import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;


public class TwitterBot {
    private final WebDriver driver;
    public TwitterBot() {
        // Initialize the WebDriver (You can change this based on your browser preference)
        this.driver = new SafariDriver();
        driver.manage().window().maximize();

    }

    public void login(String username, String password) throws InterruptedException {
        driver.get("https://twitter.com/i/flow/login");
        TimeUnit.SECONDS.sleep(5);

        WebElement userLogin = driver.findElement(By.xpath("//*[@id='layers']/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[5]/label/div/div[2]/div"));
        userLogin.click();
        userLogin.sendKeys(username);

        TimeUnit.SECONDS.sleep(2);

        WebElement pwdButton = driver.findElement(By.xpath("//*[@id='layers']/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[6]"));
        pwdButton.click();

        TimeUnit.SECONDS.sleep(2);

        WebElement pwdLogin = driver.findElement(By.xpath("//*[@id='layers']/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[3]/div/label/div/div[2]/div[1]"));
        pwdLogin.sendKeys(password);

        TimeUnit.SECONDS.sleep(2);

        WebElement loginBtn = driver.findElement(By.xpath("//*[@id='layers']/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div"));
        loginBtn.click();

        TimeUnit.SECONDS.sleep(2);

    }

    public void createAndSendTweet(String tweet) throws InterruptedException {
        WebElement tweetBtn = driver.findElement(By.xpath("//*[@id='react-root']/div/div/div[2]/header/div/div/div/div[1]/div[3]/a/div/span"));
        tweetBtn.click();

        TimeUnit.SECONDS.sleep(2);

        WebElement tweetText = driver.findElement(By.xpath("//*[@id='layers']/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div/div[3]/div[2]/div[1]/div/div/div/div[1]/div[2]/div/div/div/div/div/div/div[2]/div/div/div/div/label/div[1]/div/div/div/div/div/div[2]/div/div/div/div"));
        tweetText.sendKeys(tweet);

        TimeUnit.SECONDS.sleep(2);

        WebElement sendBtn = driver.findElement(By.xpath("//*[@id='layers']/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div/div[3]/div[2]/div[1]/div/div/div/div[2]/div[2]/div/div/div[2]/div[4]/div/span"));
        sendBtn.click();

        TimeUnit.SECONDS.sleep(2);

    }

    public void goToProfile() {

        WebElement goToProfile = driver.findElement(By.xpath("//*[@id='react-root']/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[9]/div/div[2]/span"));
        goToProfile.click();

    }

    public void deleteTweet() throws InterruptedException {

        goToProfile();

        TimeUnit.SECONDS.sleep(3);

        WebElement moreOptionsBtn = driver.findElement(By.xpath("//*[@id='react-root']/div/div/div[2]/main/div/div/div/div[1]/div/div[3]/div/div/section/div/div/div/div/div[1]/div/div/article/div/div/div[2]/div[2]/div[1]/div/div[2]/div"));
        moreOptionsBtn.click();

        TimeUnit.SECONDS.sleep(3);

        WebElement deleteBtn = driver.findElement(By.xpath("//*[@id='layers']/div[2]/div/div/div/div[2]/div/div[3]/div/div/div/div[1]/div[2]/div/span"));
        deleteBtn.click();

        TimeUnit.SECONDS.sleep(3);

        WebElement verifyDeleteBtn = driver.findElement(By.xpath("//*[@id='layers']/div[2]/div/div/div/div/div/div[2]/div[2]/div[2]/div[1]/div/span/span"));
        verifyDeleteBtn.click();

    }

    public void logout() throws InterruptedException {

        WebElement profileDropdown = driver.findElement(By.xpath("//*[@id='react-root']/div/div/div[2]/header/div/div/div/div[2]/div/div/div[2]/div/div[1]/div/div[1]/span/span[1]"));
        profileDropdown.click();

        TimeUnit.SECONDS.sleep(1);

        WebElement logoutBtn = driver.findElement(By.xpath("//*[@id='layers']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/a[2]/div[1]/div/span"));
        logoutBtn.click();

        TimeUnit.SECONDS.sleep(2);

        WebElement verifyLogout = driver.findElement(By.xpath("//*[@id='layers']/div[2]/div/div/div/div/div/div[2]/div[2]/div[2]/div[1]/div/span/span"));
        verifyLogout.click();

    }

    public void closeDriver() throws InterruptedException {

        TimeUnit.SECONDS.sleep(5);
        driver.quit();

    }

    public static void main(String[] args) throws InterruptedException {

        TwitterBot bot = new TwitterBot();
        bot.login("cagantkoc", "20122013Aa");
        bot.createAndSendTweet("from a bot");
        bot.goToProfile();
        bot.deleteTweet();
        bot.logout();
        bot.closeDriver();

    }
}
