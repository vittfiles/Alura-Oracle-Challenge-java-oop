import com.google.gson.annotations.SerializedName;

public class ConversionRate {
    private String result;
    @SerializedName("base_code")
    private String baseCode;
    @SerializedName("target_code")
    private String targetCode;
    @SerializedName("conversion_rate")
    private double conversionRate;
    @SerializedName("conversion_result")
    private double conversionResult;
    @SerializedName("error_type")
    private String errorType;

    public String getErrorType() {
        return errorType;
    }

    public String getResult() {
        return result;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public double getConversionResult() {
        return conversionResult;
    }
}
