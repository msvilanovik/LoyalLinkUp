import { Business } from "./business"

export interface Event {
    id: number,
    name: string,
    date_time: Date,
    type_of_event: string,
    capacity: number,
    business: Business
}