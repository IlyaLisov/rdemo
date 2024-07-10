## Task 1

#### Description

We accidentally dropped the database where we store the current billing status
for our advertisers. Fortunately, we still have the logs for
all the transactions they did, and we can use this to recreate the dropped data.

You are asked to process the financial transactions from the old system to build
up a BillingStatus per user to be stored in our new system.
You should create a class called BillingStatus, which will represent an account
state.

Each financial transaction represents a modification
to a BillingStatus. A BillingStatus should be able to ingest new transactions
that are generated in our own systems.
Given a collection of financial transactions, we want to generate a
BillingStatus instance for each user. This can be represented as an object:
`{ userId: BillingStatus(), userId2: BillingStatus()}`
Our BillingStatus class should start with two monetary columns:
`“adDeliveryPennies”: 0, “paymentPennies”: 0`

Each transaction can have multiple monetary columns. Upon processing a
transaction, the values in the monetary columns should be added to the
current value in the BillingStatus.
Given this input:

```
const monetaryColumns = [“adDeliveryPennies”, “paymentPennies”];
const transactions = {
“ff8bc1c2-8d45-11e9-bc42-526af7764f64”: {“userId”: 1, “adDeliveryPennies”: 1000, “transactionTimestamp”: 1500000001},
“ff8bc2e4-8d45-11e9-bc42-526af7764f64”: {“userId”: 1, “adDeliveryPennies”: 1000, “transactionTimestamp”: 1500000002},
“ff8bc4ec-8d45-11e9-bc42-526af7764f64”: {“userId”: 1, “paymentPennies”: 500, “transactionTimestamp”: 1500000003},
“fv24z4ec-8d45-11e9-bc42-526af7764f64”: {“userId”: 1, “adDeliveryPennies”: 1000, “paymentPennies”: 500, “transactionTimestamp”: 1500000004}
};
```

Expected Output (format however you want):

```
{1: BillingStatus(‘adDeliveryPennies’=3000, ‘paymentPennies’=1000)}
```