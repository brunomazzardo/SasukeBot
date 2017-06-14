
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import org.apache.commons.io.FileUtils;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

import net.dv8tion.jda.client.events.group.GroupUserJoinEvent;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.StatusChangeEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.core.events.user.UserOnlineStatusUpdateEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.managers.AudioManager;

public class BotListener extends ListenerAdapter {
	private AudioPlayerManager playerManager = new DefaultAudioPlayerManager();
	private Guild guild;
	private String sala = "General";
	private File pathPadrão = new File("C:/Users/brun0_000/Desktop/OST/Naruto - Original Soundtrack");
	private Random random = new Random();

	@Override
	public void onMessageReceived(MessageReceivedEvent e) {
		String message = e.getMessage().getRawContent();

		if (message.startsWith("!musica")) {
			if (message.startsWith("!musica yt")) {
				musicHandlerYT(e);
			} else {
				musicHandlerLocal(e, recursive(pathPadrão,

						e.getMessage().getRawContent().substring(8, e.getMessage().getRawContent().length())));

			}
		} else if (message.startsWith("!ninja")) {
			e.getAuthor().openPrivateChannel().complete();
			e.getAuthor().getPrivateChannel()
					.sendMessage(e.getAuthor().getAsMention()
							+ " Meu nome é Sasuke Uchiha. Eu odeio um monte de coisas, e eu particularmente não gosto de nada. O que eu tenho não é um sonho, porque eu vou torná-lo uma realidade. Vou restaurar meu clã, e matar um certo alguém.")
					.queue();
			;

		} else if (message.startsWith("!listaNaruto")) {
			if (!e.getAuthor().hasPrivateChannel())
				e.getAuthor().openPrivateChannel();

			File file = new File("fullsound/naruto.txt");

			try {
				e.getAuthor().getPrivateChannel().sendFile(file, e.getMessage()).queue();
			} catch (IOException e1) {
				System.out.println("erro");
				e1.printStackTrace();
			}

		} else if (message.startsWith("!stop")) {
			musicHandlerLocal(e, "");
		} else if (message.contains("thumbsup")) {
			e.getChannel().sendMessage(e.getAuthor().getAsMention() + " Do caralho hein irmão").queue();
		} else if (message.startsWith("!sala")) {
			sala = e.getMessage().getRawContent().substring(6, e.getMessage().getContent().length());
			System.out.println(sala);

		} else if (e.getAuthor().getId().equals("312783440502063104")) {
			e.getChannel()
					.sendMessage(e.getAuthor().getAsMention()
							+ "Cale-se, pelo menos uma vez! Que diabos você sabe sobre isso?! Não é como se você já tivesse uma família em primeiro lugar! Você estava em seu próprio direito desde o início, o que faz com que você ache que sabe alguma coisa sobre isso?! Huh?! Eu estou sofrendo agora, porque eu tinha esses laços, como na terra você poderia entender, o que se sente ao perder tudo isso!")
					.queue();
		} else if (message.startsWith("!jogoNinja")) {
			e.getChannel().sendMessage("Jogo da Velha").queue();
			gameNaruto(e);
		} else if (message.startsWith("O que o")) {
			e.getChannel().sendMessage("Dormir agora e acordar as 2 da manhã").queue();

		} else if (e.getAuthor().getId().equals("312730624173670402")) {
			e.getChannel().sendMessage(e.getAuthor().getAsMention() + "VAI TOMAR NO CU ANTES QUE EU ME ESQUEÇA")
					.queue();
	

		} else if (message.startsWith("!d")) {
			try{
			
				int show = random.nextInt(Integer.parseInt(message.substring(2,message.length()))) + 1;
				
				e.getChannel().sendMessage(e.getAuthor().getAsMention() + " E voce rodou..."+"Plei : " + show).queue();			
			}catch (Exception e1) {
				e.getChannel().sendMessage(e.getAuthor().getAsMention() + " SEU MERDA, PORRA, RESPEITA O BOT CARALHO, TA ACHANDO QUE TRAVECO É BAGUNÇA, NÃO MANDA D20 MAIS LETRA, E RESPEITA O TAMANHO DE UM INTEGER, DEMENTE, entre 1 e 1023 bytes , PORRA").queue();		
			if(e.getAuthor().equals("284119819371151360")){
				e.getChannel().sendMessage(e.getAuthor().getAsMention()+" É TU DE NOVO,SEU UCHIHA DE BOSTA, UCHIHA DE ÓCULOS, RESPEITA O BOT PORRA ");
			}
				
			}
			
		}
	}

	public void gameNaruto(MessageReceivedEvent e) {
		Message teste = e.getChannel().sendMessage(" |s| |n| |n| ").complete();
		teste.editMessage("|n| |s| |n|").complete();

	}

	@Override
	public void onMessageReactionAdd(MessageReactionAddEvent event) {

		event.getTextChannel().sendMessage("Do caralho mesmo irmão").queue();
		System.out.println(event.getUser().getName());

	}

	public String recursive(File path, String fName) {

		File root = path;
		String fileName = fName;
		try {
			boolean recursive = true;

			Collection files = FileUtils.listFiles(root, null, recursive);

			for (Iterator iterator = files.iterator(); iterator.hasNext();) {
				File file = (File) iterator.next();
				if (file.getName().equals(fileName))
					return file.getAbsolutePath();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void musicHandlerYT(MessageReceivedEvent e) {
		String nome = e.getMessage().getRawContent().substring(11, e.getMessage().getRawContent().length());
		if (e.getGuild() != null)
			guild = e.getGuild();
		VoiceChannel myChannel = guild.getVoiceChannelsByName(sala, true).get(0);
		AudioManager manager = guild.getAudioManager();
		AudioSourceManagers.registerRemoteSources(playerManager);
		AudioPlayer player = playerManager.createPlayer();
		// MySendHandler should be your AudioSendHandler implementation
		manager.setSendingHandler(new MySendHandler(player));

		String identifier = nome;
		TrackScheduler trackScheduler = new TrackScheduler(player);

		playerManager.loadItem(identifier, new AudioLoadResultHandler() {
			@Override
			public void trackLoaded(AudioTrack track) {
				trackScheduler.queue(track);
			}

			@Override
			public void noMatches() {
				// Notify the user that we've got nothing
			}

			@Override
			public void loadFailed(FriendlyException throwable) {
				// Notify the user that everything exploded
			}

			@Override
			public void playlistLoaded(AudioPlaylist playlist) {
				// TODO Auto-generated method stub

			}

		});
		// player.playTrack();

		trackScheduler.onPlayerResume(player);
		manager.openAudioConnection(myChannel);
	}

	public void musicHandlerLocal(MessageReceivedEvent e, String nome) {
		System.out.println(e.getAuthor());
		System.out.println(e.getMessage().getRawContent());

		if (e.getGuild() != null)
			guild = e.getGuild();
		VoiceChannel myChannel = guild.getVoiceChannelsByName(sala, true).get(0);
		AudioManager manager = guild.getAudioManager();
		AudioSourceManagers.registerLocalSource(playerManager);
		AudioPlayer player = playerManager.createPlayer();
		// MySendHandler should be your AudioSendHandler implementation
		manager.setSendingHandler(new MySendHandler(player));

		String identifier = nome;
		System.out.println(nome);
		TrackScheduler trackScheduler = new TrackScheduler(player);

		playerManager.loadItem(identifier, new AudioLoadResultHandler() {
			@Override
			public void trackLoaded(AudioTrack track) {
				trackScheduler.queue(track);
			}

			@Override
			public void noMatches() {
				// Notify the user that we've got nothing
			}

			@Override
			public void loadFailed(FriendlyException throwable) {
				// Notify the user that everything exploded
			}

			@Override
			public void playlistLoaded(AudioPlaylist playlist) {
				// TODO Auto-generated method stub

			}

		});
		// player.playTrack();

		trackScheduler.onPlayerResume(player);
		manager.openAudioConnection(myChannel);
	}

}
