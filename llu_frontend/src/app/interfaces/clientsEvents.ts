import { Client } from "./client";
import { Event } from "./event";

export interface ClientsEvents {
    id: number,
    event : Event,
    client : Client
}