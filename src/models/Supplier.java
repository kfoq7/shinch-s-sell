package models;

import com.google.gson.annotations.SerializedName;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@Data
public class Supplier {

    @SerializedName("id")
    private int id;

    @SerializedName("company_name")
    private String name;

//    private int RUC;
//    private String email;
//    private int phoneNumber;
//    private String company;
    @Override
    public String toString() {
        return "Supplier={id="
                + id;
    }
}
