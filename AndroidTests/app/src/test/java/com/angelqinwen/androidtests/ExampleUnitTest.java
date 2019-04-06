package com.angelqinwen.androidtests;
import org.junit.Test;

import static com.angelqinwen.androidtests.FirstNameExtractor.extractFirstName;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;




public class ExampleUnitTest
{
    private static String DAVE = "DAVE";
    //For test name, base on the formula: methodName_Input_Result
    @Test
    public void extractFirstName_NullInput_ReturnEmptyString()
    {
       assertThat(extractFirstName(null), is(""));

    }

    @Test
    public void extractFirstName_EmptyString_ReturnEmptyString()
    {
        assertThat(extractFirstName(""), is(""));

    }

    @Test
    public void extractFirstName_FullName_ReturnsCorrect(){
        assertThat(extractFirstName("DAVE Jones"), is(DAVE));

    }

    @Test
    public void extractFirstName_FullNameAroundWhiteSpaces_ReturnsCorrect(){
        assertThat(extractFirstName("DAVE Jones "), is(DAVE));
        assertThat(extractFirstName(" DAVE Jones"), is(DAVE));
        assertThat(extractFirstName("DAVE   Jones"), is(DAVE));
        assertThat(extractFirstName("    DAVE Jones    "), is(DAVE));
        assertThat(extractFirstName("  DAVE Jones   "), is(DAVE));

    }

    @Test
    public void extractFirstName_FirstName_ReturnsCorrect(){
        assertThat(extractFirstName("DAVE"), is(DAVE));

    }

    @Test
    public void extractFirstName_FirstNameAroundWhiteSpaces_ReturnsCorrect(){
        assertThat(extractFirstName("DAVE "), is(DAVE));
        assertThat(extractFirstName(" DAVE"), is(DAVE));
        assertThat(extractFirstName(" DAVE "), is(DAVE));
        assertThat(extractFirstName("  DAVE  "), is(DAVE));

    }

    @Test
    public void extractFirstName_ThreeWords_ReturnsCorrect(){
        assertThat(extractFirstName("DAVE Dean Jones"), is(DAVE));

    }


    @Test
    public void extractFirstName_ThreeWordsAroundWhiteSpaces_ReturnsCorrect(){
        assertThat(extractFirstName("DAVE Dean Jones "), is(DAVE));
        assertThat(extractFirstName(" DAVE Dean Jones"), is(DAVE));
        assertThat(extractFirstName("  DAVE Dean Jones  "), is(DAVE));
        assertThat(extractFirstName("DAVE   Dean   Jones"), is(DAVE));
        assertThat(extractFirstName("  DAVE   Dean   Jones"), is(DAVE));
        assertThat(extractFirstName("  DAVE   Dean    Jones"), is(DAVE));

    }








}