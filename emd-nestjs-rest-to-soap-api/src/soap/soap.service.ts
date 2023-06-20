import { Injectable } from '@nestjs/common';

@Injectable()
export class SoapService {
  envelope =
    '<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">' +
    '<SOAP-ENV:Header/>' +
    '<SOAP-ENV:Body>' +
    '<ns2:GetCountryResponse xmlns:ns2="llc:jaradatbros:emd:api:soap:mongo">' +
    '<ns2:country>' +
    '<ns2:name>Japan</ns2:name>' +
    '<ns2:capital>Tokyo</ns2:capital>' +
    '<ns2:currency>JPY</ns2:currency>' +
    '</ns2:country>' +
    '</ns2:GetCountryResponse>' +
    '</SOAP-ENV:Body>' +
    '</SOAP-ENV:Envelope>';

  convert(request: {
    country: {
      name: string;
      capital: string;
      currency: string;
      abbreviation: string;
    };
  }): string {
    console.log(JSON.stringify(request, null, 2));
    return this.envelope;
  }
}
