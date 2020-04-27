package com.example.project_capstone;

import android.os.Parcel;
import android.os.Parcelable;

public class SampleBatch implements Parcelable
{
    private String receivedBy;
    private String site;
    private String batchName;
    private String cocNumber;
    private String clientName;
    private String dateReceived;
    private String timeReceived;
    private String poNumber;
    private String projectName;
    private String quote;
    private String submittedBy;
    private String invoiceTo;
    private String sampleType;
    private String prepCode;
    private String noOfSamples;
    private String containers;
    private String status;
    private String specialInstructions;
    private String reportTo;
    private String addPackage;
    private String addFlag;
    private String dueDate;
    private String shipperStatus;
    private String shipperReference;

    protected SampleBatch(Parcel in) {
        receivedBy = in.readString();
        site = in.readString();
        batchName = in.readString();
        cocNumber = in.readString();
        clientName = in.readString();
        dateReceived = in.readString();
        timeReceived = in.readString();
        poNumber = in.readString();
        projectName = in.readString();
        quote = in.readString();
        submittedBy = in.readString();
        invoiceTo = in.readString();
        sampleType = in.readString();
        prepCode = in.readString();
        noOfSamples = in.readString();
        containers = in.readString();
        status = in.readString();
        specialInstructions = in.readString();
        reportTo = in.readString();
        addPackage = in.readString();
        addFlag = in.readString();
        dueDate = in.readString();
        shipperStatus = in.readString();
        shipperReference = in.readString();

    }
    public static final Creator<SampleBatch> CREATOR = new Creator<SampleBatch>() {
        @Override
        public SampleBatch createFromParcel(Parcel in) {
            return new SampleBatch(in);
        }

        @Override
        public SampleBatch[] newArray(int size) {
            return new SampleBatch[size];
        }
    };



    public SampleBatch(String receivedBy, String site, String batchName, String cocNumber, String clientName,
                          String dateReceived, String timeReceived, String poNumber, String projectName, String quote,
                          String submittedBy, String invoiceTo, String sampleType, String prepCode,
                          String noOfSamples, String containers, String status, String specialInstructions,
                          String reportTo, String addPackage, String addFlag, String dueDate, String shipperStatus, String shipperReference) {
        this.receivedBy = receivedBy;
        this.site = site;
        this.batchName = batchName;
        this.cocNumber = cocNumber;
        this.clientName = clientName;
        this.dateReceived = dateReceived;
        this.timeReceived = timeReceived;
        this.poNumber = poNumber;
        this.projectName = projectName;
        this.quote = quote;
        this.submittedBy = submittedBy;
        this.invoiceTo = invoiceTo;
        this.sampleType = sampleType;
        this.prepCode = prepCode;
        this.noOfSamples = noOfSamples;
        this.containers = containers;
        this.status = status;
        this.specialInstructions = specialInstructions;
        this.reportTo = reportTo;
        this.addPackage = addPackage;
        this.addFlag = addFlag;
        this.dueDate = dueDate;
        this.shipperStatus = shipperStatus;
        this.shipperReference = shipperReference;
    }

    public SampleBatch() {

    }

    @Override
    public String toString() {
        return "CreateNewBatch{" +
                "receivedBy='" + receivedBy + '\'' +
                ", site='" + site + '\'' +
                ", batchName='" + batchName + '\'' +
                ", cocNumber='" + cocNumber + '\'' +
                ", clientName='" + clientName + '\'' +
                ", dateReceived='" + dateReceived + '\'' +
                ", timeReceived='" + timeReceived + '\'' +
                ", poNumber='" + poNumber + '\'' +
                ", projectName='" + projectName + '\'' +
                ", quote='" + quote + '\'' +
                ", submittedBy='" + submittedBy + '\'' +
                ", invoiceTo='" + invoiceTo + '\'' +
                ", sampleType='" + sampleType + '\'' +
                ", prepCode='" + prepCode + '\'' +
                ", noOfSamples='" + noOfSamples + '\'' +
                ", containers='" + containers + '\'' +
                ", status='" + status + '\'' +
                ", specialInstructions='" + specialInstructions + '\'' +
                ", reportTo='" + reportTo + '\'' +
                ", addPackage='" + addPackage + '\'' +
                ", addFlag='" + addFlag + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", shipperStatus='" + shipperStatus + '\'' +
                ", shipperReference='" + shipperReference + '\'' +
                '}';
    }



    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getCocNumber() {
        return cocNumber;
    }

    public void setCocNumber(String cocNumber) {
        this.cocNumber = cocNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getTimeReceived() {
        return timeReceived;
    }

    public void setTimeReceived(String timeReceived) {
        this.timeReceived = timeReceived;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getInvoiceTo() {
        return invoiceTo;
    }

    public void setInvoiceTo(String invoiceTo) {
        this.invoiceTo = invoiceTo;
    }

    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }

    public String getPrepCode() {
        return prepCode;
    }

    public void setPrepCode(String prepCode) {
        this.prepCode = prepCode;
    }

    public String getNoOfSamples() {
        return noOfSamples;
    }

    public void setNoOfSamples(String noOfSamples) {
        this.noOfSamples = noOfSamples;
    }

    public String getContainers() {
        return containers;
    }

    public void setContainers(String containers) {
        this.containers = containers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public String getReportTo() {
        return reportTo;
    }

    public void setReportTo(String reportTo) {
        this.reportTo = reportTo;
    }

    public String getAddPackage() {
        return addPackage;
    }

    public void setAddPackage(String addPackage) {
        this.addPackage = addPackage;
    }

    public String getAddFlag() {
        return addFlag;
    }

    public void setAddFlag(String addFlag) {
        this.addFlag = addFlag;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getShipperStatus() {
        return shipperStatus;
    }

    public void setShipperStatus(String shipperStatus) {
        this.shipperStatus = shipperStatus;
    }

    public String getShipperReference() {
        return shipperReference;
    }

    public void setShipperReference(String shipperReference) {
        this.shipperReference = shipperReference;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(receivedBy);
        dest.writeString(site);
        dest.writeString(batchName);
        dest.writeString(cocNumber);
        dest.writeString(clientName);
        dest.writeString(dateReceived);
        dest.writeString(timeReceived);
        dest.writeString(poNumber);
        dest.writeString(projectName);
        dest.writeString(quote);
        dest.writeString(submittedBy);
        dest.writeString(invoiceTo);
        dest.writeString(sampleType);
        dest.writeString(prepCode);
        dest.writeString(noOfSamples);
        dest.writeString(containers);
        dest.writeString(status);
        dest.writeString(specialInstructions);
        dest.writeString(reportTo);
        dest.writeString(addPackage);
        dest.writeString(dueDate);
        dest.writeString(shipperStatus);
        dest.writeString(shipperReference);
    }
}
