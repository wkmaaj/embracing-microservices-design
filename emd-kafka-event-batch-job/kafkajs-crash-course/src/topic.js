const { Kafka } = require("kafkajs")

async function run() {
  try {
    const kafka = new Kafka({
      clientId: "kafkajs-crash-course",
      brokers: ["wkmaajs-MBP.lan:9092"]
    })
    const admin = kafka.admin()
    console.log("Connecting...")
    await admin.connect()
    console.log("Connected!")

    await admin.createTopics({
      topics: [
        {
          topic: "Users",
          numPartitions: 2
        }
      ]
    })
    console.log("Topic created successfully!")
    await admin.disconnect()
  } catch (error) {
    console.error(`An error occurred: ${error}`)
  } finally {
    process.exit(0)
  }
}

run()
