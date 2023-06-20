import { Controller, Get } from '@nestjs/common';
import { AppService } from './app.service';
import { SoapService } from './soap/soap.service';

@Controller()
export class AppController {
  constructor(
    private readonly appService: AppService,
    private readonly soapService: SoapService,
  ) {}

  @Get()
  getHello(): string {
    return `${this.appService.getHello()} ${this.soapService.convert({
      country: {
        name: 'Jordan',
        capital: 'Amman',
        currency: 'JOR',
        abbreviation: 'JO',
      },
    })}`;
  }
}
