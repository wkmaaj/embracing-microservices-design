db.createUser({
  user: "admin",
  pwd: "pwd123!",
  roles: [
    {
      role: "readWrite",
      db: "emd-spring-mongo-soap-provider"
    }
  ]
})

// https://www.mongodb.com/docs/manual/reference/method/db.getSiblingDB/#use-multiple-databases
db.Countries.insertMany([
  {
    name: "United States of America",
    capital: "Washington D.C.",
    isoCurrency: "USD",
    abbreviation: "US"
  },
  {
    name: "United Kingdom",
    capital: "London",
    isoCurrency: "GBP",
    abbreviation: "UK"
  },
  { name: "Italy", capital: "Rome", isoCurrency: "EUR", abbreviation: "IT" },
  { name: "Jordan", capital: "Amman", isoCurrency: "JOR", abbreviation: "JO" },
  { name: "Japan", capital: "Tokyo", isoCurrency: "JPY", abbreviation: "JP" }
])

db.Bikes.insertMany([
  {
    name: "Cannondale",
    frontChainwheel: {
      manufacturer: "SRAM",
      model: "Red",
      name: ""
    },
    frontDerailleur: {},
    rearDerailleur: {},
    cassetteSprocket: {}
  },
  {
    name: "Tommaso",
    frontChainwheel: {
      manufacturer: "Shimano",
      model: "Dura-Ace",
      name: ""
    },
    frontDerailleur: {},
    rearDerailleur: {},
    cassetteSprocket: {}
  }
])
