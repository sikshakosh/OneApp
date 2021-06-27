package com.android.oneapp.adapters;

public class ConnectionModel {

    public static final int INVITATION_TYPE = 0;
    public static final int CONNECTIOIN_TYPE = 1;
    public static final int INVITATION_HEADER = 2;
    public static final int INVITATION_SHOW_MORE = 3;

    public int type;
    public String title;
    public String subtitle;
    public String detail;


    public int getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDetail() {
        return detail;
    }

    public ConnectionModel(int type, String title, String subtitle, String detail) {
        this.type = type;
        this.title = title;
        this.subtitle = subtitle;
        this.detail = detail;
    }
}
