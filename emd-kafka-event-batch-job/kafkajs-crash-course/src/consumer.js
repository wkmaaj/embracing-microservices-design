const { Kafka, Partitioners } = require("kafkajs")
const stringify = require("safe-stable-stringify")

async function run() {
  try {
    const kafka = new Kafka({
      clientId: "kafkajs-crash-course",
      brokers: ["wkmaajs-MBP.lan:9092"]
    })

    const consumer = kafka.consumer({
      groupId: "kafkajs-crash-course"
    })

    console.log("Connecting...")
    await consumer.connect()
    console.log("Connected!")

    // By not disconnecting keeps consumer in a polling state
    await consumer.subscribe({
      topic: "Users",
      fromBeginning: true
    })

    await consumer.run({
      eachMessage: async (result) => {
        // console.log(stringify(result, null, 2))
        console.log(
          `Received message: ${result.message.value} on partition: ${result.partition}`
        )
      }
    })
  } catch (error) {
    console.error(`An error occurred: ${error}`)
  } finally {
    // No finally block to keep consumer in polling state
  }
}

run()
