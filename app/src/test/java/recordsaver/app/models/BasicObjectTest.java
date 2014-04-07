package recordsaver.app.models;

import com.jphili.recordsaver.app.models.BasicObject;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BasicObjectTest {

    @Test
    public void showCorrectJsonFromObject() {
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("obj1");
        stringList.add("obj2");
        BasicObject basicObject = new BasicObject("yo", 1l, stringList);

        assertThat(basicObject.toJsonString(), is("{}"));
    }
}
