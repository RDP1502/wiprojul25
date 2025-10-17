export interface IUser {
    id?:number;
    firstName?:string;
    lastName?:string;
    emailId:string;
    passWord:string;
    salt?:string;
    address?:string;
    userType?:number;
    isLoggedIn?:boolean;
}
