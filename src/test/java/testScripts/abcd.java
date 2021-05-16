package testScripts;

import helpers.JsonCreator;
import org.json.JSONObject;

import java.net.UnknownHostException;

public class abcd {

/*    Stack stk = new Stack();

    public void push(E obj)
    {
        stk.push(obj);
    }

    public E pop()
    {
        E obj =stk.pop();
        return obj;
    }*/
    public static void main(String[] args) throws UnknownHostException, InterruptedException {

//        String a="? 11,999 (27% off )";
//        String b="? 11,999.00";
//
//        System.out.println(a.split(" ")[1]);
//        System.out.println(b.split(" ")[1].replace(".00",""));

//        System.setProperty("webdriver.chrome.driver","c:/selenium/libs/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://pricee.com");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        driver.findElement(By.name("q")).sendKeys("Samsung Galaxy M30");
//        Thread.sleep(3000);
//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.PAGE_DOWN);
//        String priceePrice= driver.findElement(By.xpath("(//span[contains(text(),'Samsung Galaxy M30')])[1]/../../../div[2]")).getText();
//        System.out.println("priceePrice:"+priceePrice);
//        driver.findElement(By.xpath("(//span[contains(text(),'Samsung Galaxy M30')])[1]")).click();
//
//
//        Thread.sleep(4000);
//        String amazonPrice = driver.findElement(By.xpath("(//span[contains(text(),'11,999')])[2]")).getText();
//        System.out.println("Amazon Price:"+amazonPrice);

//        driver.get("https://demostore.x-cart.com/electronics/smart-watches/");
//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.xpath("(//span[@class='price product-price'])[7]"))).build().perform();
//        driver.findElement(By.xpath("(//label[@title='Add to compare'])[1]")).click();
//
//        actions.moveToElement(driver.findElement(By.xpath("(//span[@class='price product-price'])[9]"))).build().perform();
//        driver.findElement(By.xpath("(//label[@title='Add to compare'])[3]")).click();
//
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("(//a[text()='comparison table'])[2]")).click();
//
//        String a= driver.findElement(By.xpath("(//span[@class='price product-price'])[7]")).getText();
//        String b=driver.findElement(By.xpath("(//span[@class='price product-price'])[9]")).getText();
//
//        String priceA=a.replace("$","");
//        String priceB=b.replace("$","");
//        System.out.println(priceA);
//        System.out.println(priceB);
//        float answer = Float.parseFloat(priceA)-Float.parseFloat(priceB);
//        System.out.println(answer);




/*      int a=1;
      int b=2;
      int c;
      int d;
      c=++b;
      d=a++;
      c++;
      b++;
      ++a;
        System.out.println(a +" "+b + " "+c);   //Answer : 3 4 4*/


/*        InetAddress obj1 = InetAddress.getByName("sanfoundary.com");
        InetAddress obj2= InetAddress.getByName("sanfoundary.com");
        boolean x = obj1.equals(obj2);
        System.out.println(x);
        System.out.println(obj1);
        System.out.println(obj2);*/


/*        int a=10;
        if (a<=0)
        {
            if(a==0)
            {
                System.out.println("1");
            }
            else
            {
                System.out.println("2");
            }

        }
        System.out.println("3");*/


/*        String obj ="abc";
        byte b[]=obj.getBytes();
        ByteArrayInputStream obj1= new ByteArrayInputStream(b);
        for(int i=0;i<2;i++)
        {
            int c;
            while((c=obj1.read())!=-1){
                if(i==0)
                {
                    System.out.println(Character.toUpperCase((char)c));
                }
            }
        }*/


/*         testScripts.abcd gs=new testScripts.abcd();
         gs.push("Hello");
        System.out.println(gs.pop());*/



/*try{
    Class c = Class.forName("java.awt.Dimension");
    Constructor con[] = c.getConstructors();
    for(int i=0;i<con.length;i++)
    {
        System.out.println(con[i]);
    }
        }catch(Exception e)
{
    System.out.println("Exception");
}*/


        /*  HashMap obj=new HashMap();
       obj.put("A",new Integer(1));
       System.out.println(obj);
*/


  /*   StringBuffer s1=new StringBuffer("hello");
     s1.deleteCharAt(1);

       System.out.println(s1);*/

     /*  BitSet obj1 = new BitSet(5);
       BitSet obj2 = new BitSet(10);
       for (int i = 0; i < 5; i++)
           obj1.set(i);
       for (int i = 3; i < 13; i++)
           obj2.set(i);
       obj1.and(obj2);
       System.out.println(obj1);  //  {3, 4}*/


    /* int i;
       for ( i = 0; i < 100; i++)
           if(i==33)
               continue;
       System.out.println(i);*/


/*        String test1=new String("Test");
        String test2="Test";
        String test3=test1;
        System.out.println(test1.equals(test2));
        System.out.println(test1==test2);
        System.out.println(test1.equals(test3));  // true false true ia answer*/

        String[] jsonRequestKeySet = {"a","b","c","d"};
        String[] jsonRequestValSet = {"1","3","45","FALSE"};
        JSONObject payload = JsonCreator.parse(JsonCreator.jsonReader("test.json"),jsonRequestKeySet,jsonRequestValSet);
        System.out.println(payload);
    }
}
