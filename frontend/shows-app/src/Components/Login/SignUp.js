import './SignUp.css';

function SignUp() {
  return (
    <>
    <div className='full-page'>
        <main className='central-box'>
            <h1 className='title'>Sign Up</h1>
            <div className="inputs">
                <input className='email' placeholder='Email' type="text"/> 
                <input className='password' placeholder='Password' type="text"/> 
            </div>
            <p className='question'>Don't have an account? <a href='/sign-in' className='link-sign-in'>Sign in</a></p>
        </main>
    </div>
    </>
  );
}

export default SignUp;
