package org.example.HW6;

import org.junit.jupiter.api.Test;

public class ResetFilterTest extends AbstractTest{
    @Test
    public void checkResetFilter(){
        ResetFilter resetFilter = new ResetFilter(getWebDriver());
        resetFilter.choiceAllGenreClick()
                .choiceGenreClick()
                .choiceFormClick()
                .elementResetFilterClick(getWait());
    }
}
