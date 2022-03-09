package zw.co.zb.bdcrbz.DTO;

public class RestResponse {
    private Integer statusCode;
    private String description;
    private Integer numberResponse;
    private String stringResponse;
    private Errors errors;
    private ModelDTO model;
    private String models;
    private Page pageable;
    private String message;
    private String  timestamp;
    private String  status;



    public RestResponse() {
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumberResponse() {
        return numberResponse;
    }

    public void setNumberResponse(Integer numberResponse) {
        this.numberResponse = numberResponse;
    }

    public String getStringResponse() {
        return stringResponse;
    }

    public void setStringResponse(String stringResponse) {
        this.stringResponse = stringResponse;
    }

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }

    public ModelDTO getModel() {
        return model;
    }

    public void setModel(ModelDTO model) {
        this.model = model;
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public Page getPageable() {
        return pageable;
    }

    public void setPageable(Page pageable) {
        this.pageable = pageable;
    }
}
