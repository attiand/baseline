import org.eclipse.jgit.api.Git

@Grapes(
    @Grab(group='org.eclipse.jgit', module='org.eclipse.jgit', version='4.8.0.201706111038-r')
)

class Database {

	Database() {
		Git git = Git.cloneRepository()
		.setURI("https://github.com/eclipse/jgit.git")
		.setDirectory(new File("/tmp/repo"))
		.call();
	}
}