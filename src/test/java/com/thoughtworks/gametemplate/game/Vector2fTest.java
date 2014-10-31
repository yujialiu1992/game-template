package com.thoughtworks.gametemplate.game;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Vector2fTest {

    @Test
    public void shouldMakeVectorTwiceAsLongWhenScaledBy2() {
        Vector2f vector = new Vector2f(1, 2);
        Vector2f vectorTimes2 = new Vector2f(2, 4);

        assertThat(vector.scale(2), is(vectorTimes2));
    }
}