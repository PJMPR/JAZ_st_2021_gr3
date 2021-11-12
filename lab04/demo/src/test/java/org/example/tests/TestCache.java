package org.example.tests;

import org.example.caching.Cache;
import org.example.model.Dictionary;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestCache {

    @Test
    public void test_should_check_if_there_is_only_one_instance_of_cache(){
        List<Cache> caches = new ArrayList<>();
        List.of(1,2,3,4,5,6,7,8,9,10).stream()
                .parallel().forEach((x)->{
                    caches.add(Cache.getInstance());
                });
        assertThat(caches, everyItem(sameInstance(Cache.getInstance())));
    }

    @Test
    public void test_should_check_adding_an_item_works_correctly(){
        Cache.getInstance().putData("test", "Test");
        Cache.getInstance().putData("number", 1);
        Cache.getInstance().putData("object", new Dictionary(1,2,"3","4","5"));

        String test = Cache.getInstance().getData("test",String.class);
        int number = Cache.getInstance().getData("number", Integer.class);
        Dictionary object = Cache.getInstance().getData("object", Dictionary.class);
        assertThat(test, is("Test"));
        assertThat(number, is(1));
        assertThat(object.getDictionaryName(), is("5"));
        assertThat(object.getId(), is(1));
        assertThat(object.getIntKey(), is(2));
        assertThat(object.getStringKey(), is("3"));
        assertThat(object.getValue(), is("4"));
    }
}
