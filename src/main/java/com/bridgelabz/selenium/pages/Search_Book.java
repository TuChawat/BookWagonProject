/**
 * Description : BooksWagon.java is test file which is having test cases for Bookswagon.
 * Author      : Tushar Chawat
 * Date        : 08/06/2021
 */

package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Search_Book {
    public static LinkedList<String> bookNames = new LinkedList<>();

    @FindBy(xpath = "//a[text() = 'Featured Authors']")
    WebElement Authors;

    @FindBy(xpath = "//a[text() = 'John Green']")
    WebElement John;

    @FindBy(xpath = "//div[@class = 'product-summary']")
    List<WebElement> Books;

    @FindBy(xpath = "//*[@id=\"listSearchResult\"]/div[1]/div[3]/div[1]/a")
    WebElement Name;

    public Search_Book(WebDriver driver) { PageFactory.initElements(Base.driver, this);
    }

    public void SearchItem() throws InterruptedException {
        Authors.click();
        John.click();
        Iterator<WebElement> titleIterator = Books.iterator();
        while (titleIterator.hasNext()) {
            String news = titleIterator.next().getText();
            bookNames.add(news);
        }
        bookNames.forEach(element ->{
            System.out.println(element);
            System.out.println(" ");
        });
        Thread.sleep(2000);
        Name.click();
    }
}
