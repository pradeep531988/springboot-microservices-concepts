set VAULT_ADDR=http://127.0.0.1:8200
vault login
vault kv put secret/catalog-service @catalog-service-auth.json
https://www.vaultproject.io/docs/secrets/mysql/index.html