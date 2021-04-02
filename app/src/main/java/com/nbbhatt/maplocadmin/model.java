package com.nbbhatt.maplocadmin;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Toast;

import java.io.Serializable;

public class model /*implements Parcelable */ implements Serializable {

    String Email, Name ,Number , Password, UserLatitude , UserLongitude;

    model(){

    }

    public model(String email, String name, String number, String password, String lati, String longi) {
        this.Email = email;
        this.Name = name;
        this.Number = number;
        this.Password = password;
        this.UserLatitude = lati;
        this.UserLongitude = longi;
    }

    /*
    protected model(Parcel in) {
        Email = in.readString();
        Name = in.readString();
        Number = in.readString();
        Password = in.readString();
        UserLatitude = in.readString();
        UserLongitude = in.readString();
    }

    public static final Creator<model> CREATOR = new Creator<model>() {
        @Override
        public model createFromParcel(Parcel in) {
            return new model(in);
        }

        @Override
        public model[] newArray(int size) {
            return new model[size];
        }
    };

*/

    public String getEmail() {
        return Email;
    }


    public String getName() {
        return Name;
    }


    public String getNumber() {
        return Number;
    }


    public String getPassword() {
        return Password;
    }


    public String getUserLatitude() {
        return UserLatitude;
    }



    public String getUserLongitude() {
        return UserLongitude;
    }

/*
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Email);
        parcel.writeString(Name);
        parcel.writeString(Number);
        parcel.writeString(Password);
        parcel.writeString(UserLatitude);
        parcel.writeString(UserLongitude);
    }
 */
}

