package jbuilder.org.android_dagger2_demo.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by d05660ddw on 16/9/4.
 */
public class Repository implements Parcelable {
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_BIG = 1;
    public static final int TYPE_FEATURED = 2;

    public long id;
    public String name;
    public String url;
    public int stargazers_count;
    public int forks_count;

    public  Repository() {

    }

    protected Repository(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.url = in.readString();
        this.stargazers_count = in.readInt();
        this.forks_count = in.readInt();
    }

    public static final Creator<Repository> CREATOR = new Creator<Repository>() {
        @Override
        public Repository createFromParcel(Parcel in) {
            return new Repository(in);
        }

        @Override
        public Repository[] newArray(int size) {
            return new Repository[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(url);
        dest.writeInt(this.stargazers_count);
        dest.writeInt(this.forks_count);
    }
}
