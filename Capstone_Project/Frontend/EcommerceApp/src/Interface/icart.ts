import { ICartItem } from "./icart-item"

export interface ICart {
    id?:number
    userId:number
    totalQty:number
    totalPrice:number
    cartItems:ICartItem[]
}
