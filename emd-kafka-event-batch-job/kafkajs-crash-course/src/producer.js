import logger from "emd-nodejs-pino-logger"
import { Kafka, Partitioners } from "kafkajs"
import { allColors, getRandomColor } from "nodejs-color-module"
import stringify from "safe-stable-stringify"

async function run(msg) {
  try {
    const kafka = new Kafka({
      clientId: "kafkajs-crash-course",
      brokers: ["wkmaajs-MBP.lan:9092"]
    })

    const producer = kafka.producer({
      createPartitioner: Partitioners.LegacyPartitioner
    })

    console.log("Connecting...")
    await producer.connect()
    console.log("Connected!")
    console.log(getRandomColor())
    logger("kafkajs").trace(allColors)

    // A-M => partition 0, N-Z => partition 1
    const partition = msg[0] < "N" ? 0 : 1

    const result = await producer.send({
      topic: "Users",
      messages: [
        {
          value: msg,
          partition
        }
      ]
    })

    console.log(`Sent successfully!\n${stringify(result, null, 2)}`)
    await producer.disconnect()
  } catch (error) {
    console.error(`An error occurred: ${error}`)
  } finally {
    process.exit(0)
  }
}

run(process.argv[2])
