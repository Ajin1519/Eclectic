import React,{useState} from "react"
export default function RegisterPage(){
    const [inputs,setInputs] = useState({name:"",email:"",password:""});
    const handleOnChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        setInputs({...inputs,[name]:value});
    }
    const handleSubmit = (event)=>{
        event.preventDefault();
        console.log(inputs);
    }
    return(
        <div>
            <form onSubmit={handleSubmit}>
                <label>Name</label>
                <input type="text" name="name" value={inputs.name} onChange={handleOnChange}></input>
                <label>Email</label>
                <input type="text" name="email" value={inputs.email} onChange={handleOnChange}></input>
                <label>Password</label>
                <input type="password" name="password" value={inputs.password} onChange={handleOnChange}></input>
                <input type="submit"/>
            </form>
        </div>
    )
}