package io.github.nubesgen.configuration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NubesgenConfiguration {

    private Date date = new Date();

    private String region;

    private String applicationName;

    @JsonProperty("type")
    private ApplicationType applicationType;

    @JsonProperty("database")
    private DatabaseConfiguration databaseConfiguration;

    @JsonProperty("addons")
    private List<AddonConfiguration> addons = new ArrayList<>();

    public NubesgenConfiguration() {
        this.region = "eastus";
        this.applicationName = "sample-nubes-application";
        this.applicationType = ApplicationType.APP_SERVICE;
        this.databaseConfiguration = new DatabaseConfiguration();
    }

    public Date getDate() {
        return date;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public ApplicationType getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(ApplicationType applicationType) {
        this.applicationType = applicationType;
    }

    public DatabaseConfiguration getDatabaseConfiguration() {
        return databaseConfiguration;
    }

    public void setDatabaseConfiguration(DatabaseConfiguration databaseConfiguration) {
        this.databaseConfiguration = databaseConfiguration;
    }

    public List<AddonConfiguration> getAddons() {
        return addons;
    }

    public void setAddons(List<AddonConfiguration> addons) {
        this.addons = addons;
    }

    @JsonIgnore
    public boolean isApplicationTypeAppService() {
        return ApplicationType.APP_SERVICE.equals(this.getApplicationType());
    }

    @JsonIgnore
    public boolean isApplicationTypeFunction() {
        return ApplicationType.FUNCTION.equals(this.getApplicationType());
    }

    @JsonIgnore
    public boolean isDatabaseTypeNone() {
        return DatabaseType.NONE.equals(this.databaseConfiguration.getDatabaseType());
    }

    @JsonIgnore
    public boolean isDatabaseTypeSqlServer() {
        return DatabaseType.SQL_SERVER.equals(this.databaseConfiguration.getDatabaseType());
    }

    @JsonIgnore
    public boolean isDatabaseTypeMysql() {
        return DatabaseType.MYSQL.equals(this.databaseConfiguration.getDatabaseType());
    }

    @JsonIgnore
    public boolean isDatabaseTypePostgresql() {
        return DatabaseType.POSTGRESQL.equals(this.databaseConfiguration.getDatabaseType());
    }

    @JsonIgnore
    public boolean isAddonRedis() {
        return this.getAddons().stream()
                .anyMatch(addon -> AddonType.REDIS.equals(addon.getAddonType()));
    }

    @JsonIgnore
    public boolean isAddonStorageBlob() {
        return this.getAddons().stream()
                .anyMatch(addon -> AddonType.STORAGE_BLOB.equals(addon.getAddonType()));
    }

    @JsonIgnore
    public boolean isAddonCosmosdbMongodb() {
        return this.getAddons().stream()
                .anyMatch(addon -> AddonType.COSMOSDB_MONGODB.equals(addon.getAddonType()));
    }

    @Override
    public String toString() {
        return "NubesgenConfiguration{" +
                "date=" + date +
                ", region='" + region + '\'' +
                ", applicationName='" + applicationName + '\'' +
                ", applicationType=" + applicationType +
                ", databaseConfiguration=" + databaseConfiguration +
                ", addons=" + addons +
                '}';
    }
}
