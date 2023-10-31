import { Address } from "./address";

export interface Business {
    id: number,
    name: string,
    phone_number: string,
    address: Address,
    type_of_business: string
}