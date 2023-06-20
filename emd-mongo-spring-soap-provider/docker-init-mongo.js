db.createUser({
  user: "admin",
  pwd: "pwd123!",
  roles: [
    {
      role: "readWrite",
      db: "emd-mongo-spring-soap-provider"
    }
  ]
})

// https://www.mongodb.com/docs/manual/reference/method/db.getSiblingDB/#use-multiple-databases
db.Countries.insertMany([
  {
    name: "United States of America",
    capital: "Washington D.C.",
    currency: "USD",
    abbreviation: "US"
  },
  {
    name: "United Kingdom",
    capital: "London",
    currency: "GBP",
    abbreviation: "UK"
  },
  { name: "Italy", capital: "Rome", currency: "EUR", abbreviation: "IT" },
  { name: "Jordan", capital: "Amman", currency: "JOR", abbreviation: "JO" },
  { name: "Japan", capital: "Tokyo", currency: "JPY", abbreviation: "JP" }
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
