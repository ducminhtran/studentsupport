package com.meowbeos.studentsupport.model;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class CollectNews {
    private NewsPins listNewsPins;
    private GeneralNews listGeneralNews;

    public NewsPins getListNewsPins() {
        return listNewsPins;
    }

    public void setListNewsPins(NewsPins listNewsPins) {
        this.listNewsPins = listNewsPins;
    }

    public GeneralNews getListGeneralNews() {
        return listGeneralNews;
    }

    public void setListGeneralNews(GeneralNews listGeneralNews) {
        this.listGeneralNews = listGeneralNews;
    }
}
