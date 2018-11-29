package britenet;

import com.jcraft.jsch.*;
import java.io.*;
import java.util.Properties;

public class SFTP {

    public static void main(String[] args) throws JSchException, SftpException, IOException {
        String user = "dariusz.tulimowski";
        String host = "10.1.35.100";
        String password = "DaroTm1986";
        String command = "tail -f /app/logs/maproxy/maproxy.log";

        runSudoCommand(user, password, host, command);
    }


    public static void runSudoCommand(String user, String password, String host, String command) throws JSchException, IOException {

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session;

                session = jsch.getSession(user, host, 22);
                session.setPassword(password);
                session.setConfig(config);
                session.connect();
                System.out.println("Connected to " + host);
                Channel channel = session.openChannel("exec");
                ((ChannelExec) channel).setCommand("sudo su - maproxy");
                channel.connect();
                OutputStream out = channel.getOutputStream();
                out.write(("cd /app/logs/maproxy\n").getBytes());
                out.write(("tail -f maproxy.log\n").getBytes());
                out.flush();
                channel.setInputStream(null);
                ((ChannelExec) channel).setErrStream(System.err);
                InputStream in = channel.getInputStream();
                ((ChannelExec) channel).setPty(true);
               /// channel.connect();
                out.write((password + "\n").getBytes());
                out.flush();
                byte[] tmp = new byte[1024];
                while (true) {
                    while (in.available() > 0) {
                        int i = in.read(tmp, 0, 1024);
                        if (i < 0) break;
                        System.out.print(new String(tmp, 0, i));
                    }
                    if (channel.isClosed()) {
                        System.out.println("Exit status: " + channel.getExitStatus());
                        break;
                    }
                }
                channel.disconnect();
                session.disconnect();
                System.out.println("DONE");

        }

}
