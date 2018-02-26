package com.galvanize;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.galvanize.util.ClassProxy;
import com.galvanize.util.InstanceProxy;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void aTest() {
        ClassProxy _Author = ClassProxy.classNamed("com.galvanize.Author")
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(String.class)
                        .named("getFirstName")
                )
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(Void.TYPE)
                        .withParameters(String.class)
                        .named("setFirstName")
                )
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(String.class)
                        .named("getLastName")
                )
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(Void.TYPE)
                        .withParameters(String.class)
                        .named("setLastName")
                )
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(String.class)
                        .named("getFormattedName")
                );

        ClassProxy _Publisher = ClassProxy.classNamed("com.galvanize.Publisher")
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(String.class)
                        .named("getName")
                )
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(Void.TYPE)
                        .withParameters(String.class)
                        .named("setName")
                )
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(String.class)
                        .named("getCity")
                )
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(Void.TYPE)
                        .withParameters(String.class)
                        .named("setCity")
                )
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(String.class)
                        .named("getFormattedName")
                );

        ClassProxy _Book = ClassProxy.classNamed("com.galvanize.Book")
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(String.class)
                        .named("getTitle")
                )
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(Void.TYPE)
                        .withParameters(String.class)
                        .named("setTitle")
                )
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(Integer.TYPE)
                        .named("getYear")
                )
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(Void.TYPE)
                        .withParameters(Integer.TYPE)
                        .named("setYear")
                )
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(_Author.getDelegate())
                        .named("getAuthor")
                )
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(Void.TYPE)
                        .withParameters(_Author.getDelegate())
                        .named("setAuthor")
                )
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(_Publisher.getDelegate())
                        .named("getPublisher")
                )
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(Void.TYPE)
                        .withParameters(_Publisher.getDelegate())
                        .named("setPublisher")
                )
                .ensureMethod(m -> m
                        .isPublic()
                        .returns(String.class)
                        .named("getFormattedName")
                );

        InstanceProxy author = _Author.newInstance();
        author.invoke("setFirstName", "Kent");
        author.invoke("setLastName", "Beck");

        InstanceProxy publisher = _Publisher.newInstance();
        publisher.invoke("setName", "Addison-Wesley");
        publisher.invoke("setCity", "Boston");

        InstanceProxy book = _Book.newInstance();
        book.invoke("setTitle", "XP Explained");
        book.invoke("setYear", 2005);
        book.invoke("setAuthor", author.getDelegate());
        book.invoke("setPublisher", publisher.getDelegate());

        String expected = "XP Explained (2005)\n" +
                "Written by Beck, Kent\n" +
                "Published by Addison-Wesley, Boston";

        assertEquals(expected, book.invoke("getFormattedName"));
    }
}
