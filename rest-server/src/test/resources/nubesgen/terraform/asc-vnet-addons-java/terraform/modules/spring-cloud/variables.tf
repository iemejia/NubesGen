variable "resource_group" {
  type        = string
  description = "The resource group"
}

variable "application_name" {
  type        = string
  description = "The name of your application"
}

variable "environment" {
  type        = string
  description = "The environment (dev, test, prod...)"
  default     = "dev"
}

variable "location" {
  type        = string
  description = "The Azure region where all resources in this example should be created"
}

variable "database_url" {
  type        = string
  description = "The URL to the database"
}

variable "azure_application_insights_connection_string" {
  type        = string
  description = "The Azure Application Insights connection string"
}

variable "vault_id" {
  type        = string
  description = "The Azure Key Vault ID"
}

variable "vault_uri" {
  type        = string
  description = "The Azure Key Vault URI"
}

variable "azure_storage_account_name" {
  type        = string
  description = "The name of the Azure Storage account"
}

variable "azure_storage_blob_endpoint" {
  type        = string
  description = "The blob endpoint URL of the Azure Storage account"
}

variable "azure_redis_host" {
  type        = string
  description = "The Azure Cache for Redis hostname"
}

variable "azure_cosmosdb_mongodb_database" {
  type        = string
  description = "The Cosmos DB with MongoDB API database name"
}

variable "virtual_network_id" {
  type        = string
  description = "Virtual Network ID where Azure Spring Apps will be deployed"
}

variable "app_subnet_id" {
  type        = string
  description = "Azure Spring Apps apps subnet ID"
}

variable "service_subnet_id" {
  type        = string
  description = "Azure Spring Apps services subnet ID"
}

variable "cidr_ranges" {
  type        = list(string)
  description = "A list of (at least 3) CIDR ranges (at least /16) which are used to host the Spring Cloud infrastructure, which must not overlap with any existing CIDR ranges in the Subnet. Changing this forces a new resource to be created"
}
