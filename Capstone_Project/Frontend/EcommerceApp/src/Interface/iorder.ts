import { IOrderItem } from "./iorder-item"

export interface IOrder {
    id?:number
    orderId?:number
    userId?:number
    totalAmount:number
    orderStatus?:string
    orderDate?:Date
    items:IOrderItem[]
}
