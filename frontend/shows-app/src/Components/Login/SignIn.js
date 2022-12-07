import './SignIn.css';

function SignIn() {
  return (
    <>
    <div className='full-page'>
        <main className='central-box'>
            <h1 className='title'>Sign In</h1>
            <div className="inputs">
                <input className='email' placeholder='Email' type="text"/> 
                <input className='password' placeholder='Password' type="text"/> 
            </div>
            <p className='question'>Don't have an account? <a href='/sign-up' className='link-sign-up'>Sign up</a></p>
        </main>
    </div>
    </>
  );
}

export default SignIn;
