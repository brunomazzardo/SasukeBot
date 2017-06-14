

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

public class Bot {
	public static JDA jda;
	public static final String BOT_TOKEN = "MzE0ODAxMTc5MzMyOTY4NDQ5.C_9c9Q.F0_uk2qm5krEsPybWsmmK43N82Q";

	public static void main(String[] args) {
          
          try {
			jda = new JDABuilder(AccountType.BOT).addEventListener(new BotListener()).setToken(BOT_TOKEN).buildBlocking();
			
		} catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
